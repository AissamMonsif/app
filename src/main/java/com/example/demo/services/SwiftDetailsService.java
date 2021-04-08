package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.SwiftDetails;

public interface SwiftDetailsService {

	public List<SwiftDetails> findAllSwiftsDetails();

	public SwiftDetails findById(int id);

	public void saveSwiftDetails(SwiftDetails swiftDetails);

	public void deleteSwiftDetails(SwiftDetails swiftDetails);

	public List<SwiftDetails> findByIdSwift(int theId);

}
