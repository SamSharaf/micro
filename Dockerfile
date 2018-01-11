FROM airhacks/wildfly
COPY ./target/micro.war ${DEPLOYMENT_DIR}
