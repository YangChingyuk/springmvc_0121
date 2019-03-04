package com.yqx.dao;

import java.util.List;

import com.yqx.entity.Student;

public interface StudentDao {

	/**
	 * ��Ӽ�¼
	 * @param student
	 */
	public void add(Student student);
	/**
	 * ������Ӽ�¼
	 * @param list
	 */
	public void addMore(List<Student> list);
	/**
	 * ��������ɾ����¼
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * ������������ɾ����¼
	 * @param ids
	 */
	public void deleteMore(String ids);
	/**
	 * ���¼�¼
	 * @param student
	 */
	public void update(Student student);
	/**
	 * ����������ѯ������¼
	 * @param id
	 * @return
	 */
	public Student queryById(int id);
	/**
	 * ��ѯ���м�¼
	 * @return
	 */
	public List<Student> queryAll();
	/**
	 * ��ҳ��ѯ��¼
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryByPage(int currentPage,int pageSize);
	/**
	 * ������ҳ��ѯ��¼
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Student> queryByPage(int currentPage,int pageSize,String condition);
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int getTotals();
	/**
	 * ����������ȡ�ܼ�¼��
	 * @return
	 */
	public int getTotals(String condition);
}
