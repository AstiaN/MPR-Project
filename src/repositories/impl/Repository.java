package repositories.impl;

import java.sql.*;
import java.util.*;

import repositories.IRepository;
import repositories.impl.builder.IEntityBuilder;
import unitofwork.IUnitOfWork;
import unitofwork.IUnitOfWorkRepository;
import domain.Entity;

public abstract class Repository <TEntity extends Entity> implements IRepository<TEntity>, IUnitOfWorkRepository{

	protected IUnitOfWork uow;
	
	protected Connection connection;
	
	protected PreparedStatement selectByID;
	protected PreparedStatement insert;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected IEntityBuilder<TEntity> builder;
	
	protected String selectByIDSql=
			"SELECT * FROM "
			+ getTableName()
			+ " WHERE id=?";
	protected String deleteSql=
			"DELETE FROM "
			+ getTableName()
			+ " WHERE id=?";
	protected String selectAllSql=
			"SELECT * FROM " + getTableName();
	
	protected Repository(Connection connection,
			IEntityBuilder<TEntity> builder, IUnitOfWork ouw)
	{
		this.uow=uow;
		this.builder=builder;
		this.connection = connection;
		try {
			selectByID=connection.prepareStatement(selectByIDSql);
			insert = connection.prepareStatement(getInsertQuery());
			delete = connection.prepareStatement(deleteSql);
			update = connection.prepareStatement(getUpdateQuery());
			selectAll = connection.prepareStatement(selectAllSql);
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(TEntity entity)
	{
		uow.markAsNew(entity, this);
	}

	public void update(TEntity entity)
	{
		uow.markAsDirty(entity, this);
	}

	public void delete(TEntity entity)
	{
		uow.markAsDeleted(entity, this);
	}
	
	//**********************************************

	@Override
	public void persistAdd(Entity entity) {

		try {
			setUpInsertQuery((TEntity)entity);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void persistUpdate(Entity entity) {

		try {
			setUpUpdateQuery((TEntity)entity);
			update.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistDelete(Entity entity) {

		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//**********************************************
	
	@Override
	public TEntity get(int id) {

		try {
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TEntity> getAll() {

		List<TEntity> result = new ArrayList<TEntity>();
		
		try {
			ResultSet rs= selectAll.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
	
	protected abstract String getTableName();
	protected abstract String getUpdateQuery();
	protected abstract String getInsertQuery();
}
