# Compte rendu

1. Elles ressemblent a un peu des requêtes avec des mots clés bien spécifiques permettant à l'API JPA de pouvoir les interprêter en requête SQL.
2. 
3. Cela n'est pas une bonne pratique car cela toucherait à l'intégrité de l'entité. Il est préférable de retourner une copie de cette entité ou un POJO avec les mêmes données.
4. Si un artiste est supprimé, il y'aura des repercutions sur sa descendance. les musiques qui ont sont son Id seront supprimés, pareil pour les albums.
5. Toute l'entité ne sera pas chargé. par défaut, @OneToMany  utilise le FetchType.LAZY. Ce qui veut dire que toutes les données ne seront pas chargées mais seront disponibles à la demande (lors d'un appel explicite).