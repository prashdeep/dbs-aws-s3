package com.example.s3demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import com.amazonaws.regions.Regions;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import java.util.List;

@SpringBootApplication
public class S3DemoApplication implements CommandLineRunner {

	@Value("${aws.s3.accessid}")
	private String username;

	@Value("${aws.s3.accesssecret}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(S3DemoApplication.class, args);
	}

	@Override
	public void run(String args[]){
		System.out.println(" Inside the spring boot application ....");
		System.out.println("The username is "+ username);
		System.out.println("The password is "+ password);

		BasicAWSCredentials credenditals = new BasicAWSCredentials(username,password );

		final AmazonS3 s3 = AmazonS3ClientBuilder
										.standard().withRegion(Regions.AP_SOUTH_1)
										.withCredentials(new AWSStaticCredentialsProvider(credenditals))
										.build();

		Bucket newBucket = s3.createBucket("mynewbucket-using-sdk");

		System.out.println("Region name "+ s3.getRegionName());
		List<Bucket> buckets = s3.listBuckets();
		System.out.println("Number of buckers in the reqion is "+ buckets.size());
        for (Bucket b : buckets) {
				System.out.println(b);
        }
	}

}
