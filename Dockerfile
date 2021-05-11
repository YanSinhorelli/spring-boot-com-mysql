FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

# COPIA ARQUIVO DO SEU PROJETO /target/spring-boot*.jar para o container
COPY /target/spring-boot*.jar spring_boot_com_mysql.jar

SHELL ["/bin/sh", "-c"]

# EXPÕE AS PORTAS DO CONTAINER
EXPOSE 5005
EXPOSE 8080

# O COMANDO QUE SERÁ EXECUTADO APÓS A CRIÇÃO DO CONTAINER
CMD java ${ADDITIONAL_OPTS} -jar spring_boot_com_mysql.jar --spring.profiles.active=${PROFILE}
