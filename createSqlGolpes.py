fkchar = input("Digite a FK do char:");
p = "insert into golpes (id,nome,input,fk_id_char) values('*','*','df+*'," + str(fkchar) + ");\n"
f = open("dboAcao.sql","w+")
for i in range(301,315):
	aux = p.replace("*", str(i))
	print (aux)
	f.write(aux)
f.close()
