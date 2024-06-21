package org.example.springboot.dto;

import lombok.Data;
import org.example.springboot.entity.Food;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetail {
    private Integer id;

    private LocalDateTime time;

    private Integer catererId;

    private Boolean isQueueOrder;

    private Boolean isFinished;

    private List<Integer> foods;

}
