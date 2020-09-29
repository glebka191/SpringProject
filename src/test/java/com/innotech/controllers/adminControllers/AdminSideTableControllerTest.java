package com.innotech.controllers.adminControllers;

import com.innotech.entity.SideTable;
import com.innotech.service.SideTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminSideTableControllerTest {

    SideTableService sideTableServiceMock = Mockito.mock(SideTableService.class);

    SideTable testTable = new SideTable();

    @Test
    public void addSideTable() {
        testTable.setSize(5);
        Mockito.when(sideTableServiceMock.addSideTable(testTable.getSize(),testTable)).thenReturn(true);
    }

    @Test
    public void deleteSideTable() {
        Mockito.when(sideTableServiceMock.deleteSideTable(testTable.getId())).thenReturn(false);
    }

    @Test
    public void updateSideTable() {
        Mockito.when(sideTableServiceMock.updateSideTable(Mockito.any(),Mockito.anyInt()));
    }
}