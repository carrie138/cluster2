#!/bin/bash
#$ -N JAVA
#$ -o JAVA.$JOB_ID.out
#$ -e JAVA.$JOB_ID.err
#$ -cwd
#$  cluster2/bin/multiThread.MultiThread load cvettrai
