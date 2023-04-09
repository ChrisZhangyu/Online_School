FROM kdvolder/jdk8
ARG cur_path
RUN cur_path=$(pwd) && export cur_path
RUN echo "$cur_path"
VOLUME $cur_path
ARG jar_name
RUN jar_name=$(find ./ -type f -name "*.jar") && export jar_name
RUN echo "$jar_name"
ADD $jar_name.jar /home/service_vod/service_vod.jar
ENTRYPOINT  ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/service_gateway/gateway.jar"]
ENV TIMEZONE Asia/Shanghai