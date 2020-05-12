package com.slmanju.springbootbasic.employees.service.transfer.dto;

import com.slmanju.springbootbasic.core.SearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;

import lombok.Data;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class EmployeeSearchRequest extends SearchRequest<EmployeeView> {

}
