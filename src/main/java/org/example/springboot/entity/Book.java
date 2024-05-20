package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@TableName("book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String catererId;

    private LocalDateTime time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCatererId() {
        return catererId;
    }

    public void setCatererId(String catererId) {
        this.catererId = catererId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id = " + id +
            ", userId = " + userId +
            ", catererId = " + catererId +
            ", time = " + time +
        "}";
    }
}
