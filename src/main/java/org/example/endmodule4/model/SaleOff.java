package org.example.endmodule4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class SaleOff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @FutureOrPresent(message = "Ngày bắt đầu lớn hơn ngày hiện tại")
    private Date startDay;
    @NotNull
    private Date endDay;
    @NotNull
    @Min(value = 11000, message = "Mức nhỏ nhất là 11000 vnd ")
    private Double discount;
    @NotNull
    private String detail;
}
