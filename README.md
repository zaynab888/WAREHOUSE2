# Choix de Conception du Système de Gestion d'Inventaire

## 1. Pourquoi utiliser HashMap pour stocker les informations sur les produits ?

### Raison du Choix de HashMap :
- **Recherches Rapides :** Un `HashMap` fournit une complexité temporelle moyenne de **O(1)** pour les recherches, insertions et suppressions. Cela est crucial pour accéder rapidement aux informations sur les produits par leur ID unique.
- **Stockage en Paires Clé-Valeur :** Il permet de stocker les produits en paires clé-valeur, où la clé est l'ID du produit (garantissant l'unicité) et la valeur est l'objet `Product`.

### Avantages par Rapport à D'autres Structures de Données :
- **Par rapport à ArrayList :** Bien qu'un `ArrayList` puisse stocker des produits, il nécessiterait un temps **O(n)** pour trouver un produit par ID, nécessitant une recherche linéaire.
- **Par rapport à TreeMap :** Un `TreeMap` maintient les éléments dans l'ordre trié (par clés) mais a une complexité temporelle de **O(log n)** pour les recherches. Si le tri par ID n'est pas requis, le `HashMap` est plus efficace pour ce cas d'utilisation.

## 2. Utilisation d'ArrayList pour les Expéditions Quotidiennes

### Maintien de l'Ordre :
- Un `ArrayList` maintient l'ordre d'insertion. Lorsque les IDs des produits sont ajoutés à la liste au fur et à mesure que les expéditions arrivent, ils sont stockés dans l'ordre exact où ils ont été reçus. Cela permet de récupérer facilement l'ordre dans lequel les produits ont été expédiés, ce qui est essentiel pour le suivi du flux d'inventaire.

## 3. Changements pour le Tri par Nom et ID

### Changements Nécessaires :
- **Utiliser un Comparateur Personnalisé :** Lors du tri, il convient d'implémenter un comparateur personnalisé qui compare d'abord les noms et, en cas d'égalité, compare les IDs des produits.

## 4. Gestion des IDs Non Uniques et Suivi des Expéditions avec des Horodatages

### Gestion des IDs Non Uniques :
- **Changer la Structure de Données :** Au lieu d'utiliser `HashMap<String, Product>`, utilisez `Map<String, List<Product>>` où la clé est l'ID du produit et la valeur est une liste de produits partageant cet ID. Cela permet d'avoir plusieurs produits avec le même ID.

### Suivi des Expéditions avec des Horodatages :
- **Utiliser une Classe pour les Expéditions :** Créez une classe `Shipment` qui inclut à la fois l'ID du produit et un horodatage.
- **Utiliser une Liste d'Expéditions :** Modifiez `dailyShipments` pour stocker des objets `Shipment` au lieu de simples IDs. Cela permettra à chaque entrée d'expédition d'inclure à la fois l'ID et l'horodatage de la réception.
