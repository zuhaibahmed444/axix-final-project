FROM openjdk:11
VOLUME /tmp
COPY target/axis-case-study.jar axiscasestudy.jar
ENTRYPOINT ["java","-jar","axiscasestudy.jar"]