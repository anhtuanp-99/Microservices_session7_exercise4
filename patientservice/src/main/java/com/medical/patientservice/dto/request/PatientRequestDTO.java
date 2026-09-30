package com.medical.patientservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(max = 100, message = "Họ và tên không vượt quá 100 ký tự")
    private String fullName;

    @Past(message = "Ngày sinh phải là một ngày trong quá khứ")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "MALE|FEMALE|OTHER",
            message = "Giới tính chỉ nhận giá trị MALE, FEMALE hoặc OTHER")
    private String gender;

    @Pattern(regexp = "^(0|\\+84)[0-9]{9,10}$",
            message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không vượt quá 255 ký tự")
    private String address;

    @Size(max = 5000, message = "Tiền sử bệnh lý không vượt quá 5000 ký tự")
    private String medicalHistory;
}