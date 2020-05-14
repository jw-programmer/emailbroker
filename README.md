# Broker de e-mail

Este projeto é um projeto spring boot feito para se lançar e-maisl. Uma conta de email pessoal será usada para essa finalidade. Com isso, se pouca esforço no momento de se implementar um serviço de e-mail.

## Para configurar um projeto.
Sendo um projeto spring, basta baixar as dependẽncias maven e inicar normalmente. Porém, você pode criar o arquivo application-dev.propreties para poder subir um profile e colocar as informações sensíves. Em application-prod.propreties, as mesmas informações ficaram disponíveis, porém de forma sgura, para que elas sejam lidas por variáves de ambiente. No caso deste projeto, as informações a serem protejidas são as credenciais da conta de e-mail.

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
Lembresse de trocar o profile da aplicação de dev para prod na hora de realizar o deploy.

## Utilizando.
Uma vez que o broker está iniciado basta realizar uma operação de POST em /email. O objeto esperado é o descrito abaixo.

```json
{
 "recipient":"<O email de pessoa que você quer alcançar>",
  "sender":"<Seu nome. Como o email do remetente é fixo, Apenas uma identificação basta>",
  "subject":"<Assunto do email>",
  "message":"<A mensagem propríamente dita.>"
}
```
