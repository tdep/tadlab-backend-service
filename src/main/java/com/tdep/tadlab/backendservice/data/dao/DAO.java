package com.tdep.tadlab.backendservice.data.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DAO<T> {

  T get(int id) throws SQLException, ParseException;

  List<T> getAll() throws SQLException, ParseException;

  void insertOrUpdate(T t) throws SQLException;

  void delete(T t) throws SQLException;
}
