# Streaming Statistics
Eddie River has been hired by a company providing a music streaming service. His boss, Veronica Brook, wants to get an analysis of network utilization. While there are a lot of different types of requests, the bulk of the data transfer is the streaming of music files.

## compile
    mvn package

## test
    mvn test

## run
    cat samples/streamstats_sample.01.in |java -cp target/StreamingStatistics-1.0.jar fsoc.StreamingStatistics
