//package com.cog.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//@Component
//public class JobRunner1 implements CommandLineRunner {
//    private final JobLauncher jobLauncher;
//    private final Job job;
//
//    public JobRunner1(JobLauncher jobLauncher, Job job) {
//        this.jobLauncher = jobLauncher;
//        this.job = job;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        jobLauncher.run(job, new JobParametersBuilder()
//                .addLong("time", System.currentTimeMillis())
//                .toJobParameters());
//    }
//}
//
