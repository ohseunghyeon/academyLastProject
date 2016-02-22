package com.first.lastproject.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.IngredientDto;

@Repository
public class IngredientDaoImpl implements IngredientDao {
	DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getIngredient() {
		int result =0;
		IngredientDao dao = this.sqlSession.getMapper(IngredientDao.class);
		result=dao.getIngredient();
		return result;
	}

	@Override
	public List<IngredientDto> listIngredient() {
		List<IngredientDto> ingredientList = null;
		IngredientDao dao = this.sqlSession.getMapper(IngredientDao.class);
		ingredientList= dao.listIngredient();
		
		return ingredientList;
	}

	@Override
	public int modifyIngredient(Map<String, Integer> map) {
		int count = 0;
		IngredientDao dao = this.sqlSession.getMapper(IngredientDao.class);
		count =dao.modifyIngredient(map);
		return count;
	}

	@Override
	public List<IngredientDto> getIngredientForFood(int food_code) {
		List<IngredientDto> dtoList = null;
		IngredientDao dao = this.sqlSession.getMapper(IngredientDao.class);
		dtoList = dao.getIngredientForFood(food_code);
		return dtoList;
	}
	@Override
	public int reduceIngredient(int ingredient_code) {
		int count = 0;
		IngredientDao dao = this.sqlSession.getMapper(IngredientDao.class);
		count = dao.reduceIngredient(ingredient_code);
		return count;
	}
}
