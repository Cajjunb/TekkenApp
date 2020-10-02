import random
fkchar = input("Digite a FK do char:");
p = "insert into golpes (id,nome,input,personagem_id ,blockframe,hitframe,chframe) values('*','*','df+*'," + str(fkchar) + ", -1 , -2, -3 );\n"
f = open("dboAcao.sql","w+")
for i in range(301,315):
	aux = p.replace("*", str(i))
        aux = aux.replace("-1", str(random.randint(-15,15)))
        aux = aux.replace("-2", str(random.randint(-15,15)))
        aux = aux.replace("-3", str(random.randint(-15,15)))
	print (aux)
	f.write(aux)
f.close()
