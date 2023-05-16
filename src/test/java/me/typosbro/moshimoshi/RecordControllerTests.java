package me.typosbro.moshimoshi;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.typosbro.moshimoshi.collection.Record;
import me.typosbro.moshimoshi.collection.Timestamp;
import me.typosbro.moshimoshi.controller.RecordController;
import me.typosbro.moshimoshi.service.RecordService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RecordControllerTests {

    @Mock
    private RecordService recordService;

    @InjectMocks
    private RecordController controller;

    private List<Record> recordList;

    @BeforeAll
    public void setup() {
        recordList = new ArrayList<>();
        Date currentDate = new Date();
        Timestamp timestamp = Timestamp
                .builder()
                .id("1234567890")
                .tag("Tag")
                .start("2023-05-16")
                .end("2023-05-16")
                .build();

        List<Timestamp> timestamps = List.of(timestamp);

        Record savedRecord = Record
                .builder()
                .id("1234567890")
                .date(currentDate)
                .url("Test Record")
                .timestamp(timestamps)
                .build();

        recordList.add(savedRecord);

    }

    @Test
    public void testSave() {
        when(recordService.save(recordList.get(0))).thenReturn(recordList.get(0).getId());
        String id = controller.save(recordList.get(0));
        assertEquals("1234567890", id);
    }

    @Test
    public void testUpdate() {
        when(recordService.getById("1234567890")).thenReturn(recordList.get(0));
        Record savedRecord = controller.getById("1234567890");
        savedRecord.setUrl("New Test Record");
        
        when(recordService.update("1234567890", savedRecord)).thenReturn(savedRecord);
        Record updatedRecord = controller.update("1234567890", savedRecord);
        assertEquals("New Test Record", updatedRecord.getUrl());
    }

    @Test
    public void testUpdateTimestamp() {
    when(recordService.getById("1234567890")).thenReturn(recordList.get(0));
    
    Record savedRecord = controller.getById("1234567890");

    Timestamp updatedTimestamp = Timestamp
    .builder()
    .id("1234567890")
    .tag("Tag")
    .start("2023-05-17")
    .end("2023-05-18")
    .build();
    
    List<Timestamp> foo = List.of(updatedTimestamp);
    savedRecord.setTimestamp(foo);


    when(recordService.updateTimestamp(savedRecord.getId(), updatedTimestamp.getId(), updatedTimestamp)).thenReturn(savedRecord);
    Record updatedRecord = controller.updateTimestamp(savedRecord.getId(), updatedTimestamp.getId(), updatedTimestamp);
    assertEquals("2023-05-17", updatedRecord.getTimestamp().get(0).getStart());
    }

    @Test
    public void testDelete() {
    when(recordService.getById("1234567890")).thenReturn(recordList.get(0));
    Record savedRecord = controller.getById("1234567890");

    when(recordService.delete("1234567890")).thenReturn(recordList.get(0).getId());
    
    String id = controller.delete(savedRecord.getId());
    assertEquals("1234567890", id);
    }

    @Test
    public void testDeleteTimestamp() {
    when(recordService.getById("1234567890")).thenReturn(recordList.get(0));    
    Record savedRecord = controller.getById("1234567890");
    when(recordService.deleteTimestamp("1234567890", "1234567890")).thenReturn(recordList.get(0).getId());    
    String id = controller.deleteTimestamp(savedRecord.getId(), savedRecord.getTimestamp().get(0).getId());
    assertEquals("1234567890", id);
    }

    @Test
    public void testGet() {
        when(recordService.get()).thenReturn(recordList);
        List<Record> records = controller.get();
        assertNotNull(records);
        assertTrue(records.size() > 0);
    }

    @Test
    public void testGetById() {
        when(recordService.get()).thenReturn(recordList);   
        List<Record> records = controller.get();
        assertNotNull(records);
        when(recordService.getById("1234567890")).thenReturn(recordList.get(0));
        Record res = controller.getById("1234567890");
        assertNotNull(res);
        assertEquals("Test Record", res.getUrl());
    }

}
