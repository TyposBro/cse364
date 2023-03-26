FROM ubuntu:22.04

RUN apt update
RUN apt install -y git
RUN apt install openjdk-17-jdk openjdk-17-jre


WORKDIR /project