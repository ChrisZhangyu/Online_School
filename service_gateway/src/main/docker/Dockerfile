FROM kdvolder/jdk8
VOLUME /home/online_school/service_gateway
ADD service_gateway-1.0-SNAPSHOT.jar /home/service_gateway/gateway.jar
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/service_gateway/gateway.jar"]
ENV TIMEZONE Asia/Shanghai