package app;

import dao.ProjectDao;

public class MainTest {
	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();
		projectDao.getProjects().forEach((prj) -> {
			System.out.println(prj);
		});;
	}
}
