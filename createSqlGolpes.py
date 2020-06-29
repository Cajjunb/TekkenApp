fkchar = input("Digite a FK do char:");
p = "insert into golpes () values();\n"
f = open("dboAcao.sql","w+")
for i in range(301,315):
	aux = p.replace("*", str(i))
	print (aux)
	f.write(aux)
f.close()
