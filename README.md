# Gestión de Contactos - Unidad 3

Aplicación de gestión de contactos con programación concurrente.

## Compilar

Desde la raíz del proyecto:

```bash
javac -d bin src/modelo/*.java src/controlador/*.java src/vista/*.java
```

Luego copiar los archivos de idiomas:

```bash
cp -r src/idiomas bin/
```

## Ejecutar

```bash
java -cp bin vista.ventana
```

## Requisitos

- Java 8 o superior
- Compilador javac

## Características

- Validación de contactos duplicados en thread
- Búsqueda en segundo plano sin bloquear UI
- Exportación a CSV en background
- Notificaciones en tiempo real
- Sincronización en ediciones simultáneas
