# libraryZup

 Pontos a declarar:

-Diagrama de tabelas
 ![image](https://github.com/user-attachments/assets/53d49a61-a8c3-4451-90bb-ff1a746144e9)

 -Tabelas geradas no Banco de Dados

![image](https://github.com/user-attachments/assets/e38253e9-d600-4692-ab5b-04ae071a7f0b)


Authenticato

Register user POST /user

{
"name": "Fulano",
"username":"fufu",
"email":"teste.xablau@teste.com",
"password": "123mudar",
"roles": ["ADMIN"]
}
Authenticate POST /api/auth/login

{
"username":"fufu",
"password": "123mudar"
}

