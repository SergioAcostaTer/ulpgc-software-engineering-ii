# **Servicio Web con el Patrón de Diseño Adapter**

Este proyecto desarrolla un servicio web que utiliza el **patrón de diseño Adapter** para transformar solicitudes externas en un formato compatible con la arquitectura interna y viceversa. El servicio web **integra datos desde la API pública de Rick and Morty** y los procesa para ser consumidos eficientemente.

## **API Utilizada**

Se utiliza la **API pública de Rick and Morty**, la cual expone información detallada sobre personajes, ubicaciones y episodios de la serie. Para este proyecto, se trabaja específicamente con los **personajes**.

### **Endpoint Base**

https://rickandmortyapi.com/api/character/



### **Ejemplo de Consulta**
- **Endpoint para un personaje específico**:
https://rickandmortyapi.com/api/character/{id}

- `{id}` es el identificador único del personaje (por ejemplo, `1` para "Rick Sanchez").

- **Respuesta JSON Ejemplo**:
```json
{
  "id": 1,
  "name": "Rick Sanchez",
  "status": "Alive",
  "species": "Human",
  "gender": "Male",
  "origin": {
    "name": "Earth (C-137)"
  },
  "location": {
    "name": "Citadel of Ricks"
  },
  "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
}
```


## **Características del Proyecto**
- Implementación del **patrón Adapter** para desacoplar la fuente de datos externa de la arquitectura interna.
- Consumo de datos desde APIs externas con **Java**.
- Transformación de datos JSON mediante deserialización con **Gson**.
- Modularidad para facilitar la ampliación y el mantenimiento.
- Control de versiones con **Git** y **GitHub**.

## **Estructura del Proyecto**

### **Paquetes principales**
1. **io**:
   - Contiene las clases para la lectura (Reader), deserialización (Deserializer) y adaptación (Adapter) de datos.
   
2. **contracts**:
   - Define estructuras intermedias como CharacterGetResponse.

3. **model**:
   - Contiene las clases finales del modelo, como Character.

4. **main**:
   - Contiene el punto de entrada para ejecutar la aplicación.

---

## **Patrón de Diseño: Adapter**

### **Componentes del Patrón**

- **Reader (CharacterReader)**:
  Encargado de obtener datos JSON desde una fuente externa. En este caso, consume datos desde la API de Rick and Morty.
  
- **Deserializer (CharacterDeserializer)**:
  Convierte los datos JSON crudos en objetos Java intermedios (CharacterGetResponse.CharacterData).
  
- **Adapter (CharacterApiAdapter)**:
  Transforma los objetos intermedios en modelos finales (Character) que representan los datos en un formato limpio y usable.

---

## **Requisitos del Proyecto**

### **Tecnologías**
- **Java**: Lenguaje principal de desarrollo.
- **Maven**: Gestión de dependencias y construcción del proyecto.
- **Gson**: Deserialización de datos JSON.
- **JSoup**: Realización de solicitudes HTTP.
- **Git** y **GitHub**: Control de versiones y colaboración.
