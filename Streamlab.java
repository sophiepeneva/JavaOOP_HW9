# JavaOOP_HW9

package com.test;
public class StreamLab {

    public static void main(String[] args) {

        SummaryStatistics stats = new SummaryStatistics();
        stats.setup();

        stats.averageWithJava();
        stats.statsWithStreamReduce();
        stats.allStatsWithStream();

        stats.statsWithStreamAverage();
        stats.statsWithStreamMin();
        stats.statsWithStreamReduce();
       
        stats.setupCompanies();
        stats.companyStats();
        stats.companyStatsWithStreamAverage();
        
        Employee.statistics();
    }

}
