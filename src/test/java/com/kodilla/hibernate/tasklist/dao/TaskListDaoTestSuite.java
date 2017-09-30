package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    private static final String NAME = "testName";
    private static final String DESCRIPTION = "testDescription";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList
                (NAME,DESCRIPTION);
        String listName = taskList.getListName();
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listName);
        //Then
        Assert.assertEquals(1, readTaskList.size());

        //CleanUp
        taskListDao.delete(readTaskList);
        //or int id = readTaskList.get(0).getId();
        //or
        //taskListDao.delete(id);
    }
}
