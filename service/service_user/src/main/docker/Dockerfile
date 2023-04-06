FROM java:8
VOLUME /home/online_school/service/service_user
ADD service_user-1.0-SNAPSHOT.jar /home/service/service_user/user.jar
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/service/service_user/user.jar"]
ENV TIMEZONE Asia/Shanghai