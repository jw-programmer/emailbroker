# Broker de e-mail

[![Build Status](https://travis-ci.org/jw-programmer/emailbroker.svg?branch=master)](https://travis-ci.org/jw-programmer/emailbroker)

This project is a spring boot project designed to launch emails. A personal email account will be used for this purpose. This saves effort when implementing an e-mail service.

## Para configurar um projeto.
Being a spring project, just download the maven dependencies and start normally. However, you can create the application-dev.properties file in order to upload a dev profile and place sensitive information. In application-prod.properties, the same information was available, but in a secure way, so that it can be read by environment variables. In the case of this project, the information to be protected is the credentials of the email account.

```propreties
spring.mail.host=smtp.gmail.com
spring.mail.username=${SMTP_USER}
spring.mail.password=${SMTP_PASSWORD}
spring.mail.properties.mail.smtp.auth = true
spring.mail.properties.mail.smtp.socketFactory.port = 465
spring.mail.properties.mail.smtp.socketFactory.class = javax.net.ssl.SSLSocketFactory
spring.mail.properties.mail.smtp.socketFactory.fallback = false
spring.mail.properties.mail.smtp.starttls.enable = true
spring.mail.properties.mail.smtp.ssl.enable = true
``` 
Remember to change the application profile from dev to prod when deploying.

## Utilizando.
Once the broker is started, just perform a POST operation in / email. The expected object is the one described below.

```json
{
"recipient": "<The email of the person you want to reach>",
   "sender": "<Your name. Since the sender's email is fixed, just one identification is enough>",
   "subject": "<Email subject>",
   "message": "<The message properly said.>"
}
```
