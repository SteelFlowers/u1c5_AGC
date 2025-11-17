# Plan de Implementación - Unidad 3: Programación Concurrente
## Aplicación de Gestión de Contactos

---

## 📋 Resumen General
Mejorar la aplicación de gestión de contactos (existente desde U1 y U2) incorporando programación concurrente (threads, sincronización) para mejor rendimiento y eficiencia.

---


## 🎯 Requisitos a Implementar

### 1. Validación de contactos en segundo plano
- [ ] Crear thread para validar contactos duplicados antes de guardar
- **Antes:** Captura de pantalla guardando contacto duplicado
- **Después:** Captura mostrando validación en segundo plano y prevención de duplicados

### 2. Búsqueda de contactos en segundo plano
- [ ] Implementar thread independiente para búsquedas
- [ ] Usar SwingWorker o ExecutorService
- **Antes:** Captura de búsqueda bloqueando la interfaz
- **Después:** Captura de búsqueda sin bloquear UI (usuario puede interactuar)

### 3. Exportación de contactos con hilos múltiples
- [ ] Crear proceso en segundo plano para exportar a CSV
- [ ] Implementar sincronización para evitar corrupción de datos
- **Antes:** Captura de exportación bloqueando la aplicación
- **Después:** Captura de exportación sin afectar fluidez

### 4. Notificaciones en la interfaz gráfica
- [ ] Implementar thread para notificaciones en tiempo real
- [ ] Usar SwingUtilities.invokeLater() para actualizar UI correctamente
- **Antes:** Captura sin notificaciones o notificaciones síncronas
- **Después:** Captura mostrando notificaciones en tiempo real ("Contacto guardado", etc.)

### 5. Sincronización y seguridad en modificación
- [ ] Usar `synchronized` para evitar race conditions
- [ ] Implementar mecanismo de bloqueo de recursos
- [ ] Solo un usuario edita un contacto a la vez
- **Antes:** Captura de modificación sin sincronización
- **Después:** Captura mostrando bloqueo seguro al editar

---

## 📁 Estructura de Carpetas para Capturas

```
capturas/
├── antes/
│   ├── 1_validacion_antes.png
│   ├── 2_busqueda_antes.png
│   ├── 3_exportacion_antes.png
│   ├── 4_notificaciones_antes.png
│   └── 5_sincronizacion_antes.png
└── despues/
    ├── 1_validacion_despues.png
    ├── 2_busqueda_despues.png
    ├── 3_exportacion_despues.png
    ├── 4_notificaciones_despues.png
    └── 5_sincronizacion_despues.png
```

---

## 🔧 Plan de Implementación Paso a Paso

### FASE 1: PREPARACIÓN
- [ ] Revisar código actual de la aplicación
- [ ] Identificar dónde van los threads
- [ ] Crear estructura de carpetas para capturas

### FASE 2: VALIDACIÓN DE CONTACTOS EN SEGUNDO PLANO
**Paso 1:** Capturar pantalla ANTES (contacto siendo guardado sin validación)
- [ ] Ejecutar aplicación actual
- [ ] Intentar agregar contacto duplicado
- [ ] Guardar captura en `capturas/antes/1_validacion_antes.png`

**Paso 2:** Implementar validación en thread
- [ ] Crear clase `ValidadorContactosThread` (extends Thread o Runnable)
- [ ] Implementar lógica de validación de duplicados
- [ ] Integrar en método de guardar contacto
- [ ] Usar synchronized en acceso a lista de contactos

**Paso 3:** Capturar pantalla DESPUÉS
- [ ] Ejecutar aplicación con validación implementada
- [ ] Intentar agregar contacto duplicado
- [ ] Observar validación en segundo plano
- [ ] Guardar captura en `capturas/despues/1_validacion_despues.png`

### FASE 3: BÚSQUEDA DE CONTACTOS EN SEGUNDO PLANO
**Paso 1:** Capturar pantalla ANTES (búsqueda bloqueando UI)
- [ ] Ejecutar aplicación actual
- [ ] Iniciar búsqueda de contactos
- [ ] Intentar interactuar con la aplicación (botones, campos)
- [ ] Guardar captura en `capturas/antes/2_busqueda_antes.png`

**Paso 2:** Implementar búsqueda en thread
- [ ] Crear clase `BuscadorContactosWorker` (extends SwingWorker)
- [ ] Implementar doInBackground() para búsqueda
- [ ] Implementar done() para actualizar resultados
- [ ] Integrar en método de búsqueda
- [ ] Mostrar indicador de carga mientras busca

**Paso 3:** Capturar pantalla DESPUÉS
- [ ] Ejecutar aplicación con búsqueda en thread
- [ ] Iniciar búsqueda
- [ ] Intentar interactuar con la aplicación durante búsqueda
- [ ] Guardar captura en `capturas/despues/2_busqueda_despues.png`

### FASE 4: EXPORTACIÓN CON HILOS MÚLTIPLES
**Paso 1:** Capturar pantalla ANTES (exportación bloqueando)
- [ ] Ejecutar aplicación actual
- [ ] Iniciar exportación a CSV
- [ ] Observar bloqueo de interfaz
- [ ] Guardar captura en `capturas/antes/3_exportacion_antes.png`

**Paso 2:** Implementar exportación en thread
- [ ] Crear clase `ExportadorContactosThread` (extends Thread)
- [ ] Implementar sincronización en acceso a archivo (synchronized block)
- [ ] Integrar en método de exportar
- [ ] Usar locks si es necesario para múltiples exportaciones

**Paso 3:** Capturar pantalla DESPUÉS
- [ ] Ejecutar aplicación con exportación en thread
- [ ] Iniciar exportación
- [ ] Interactuar con aplicación durante exportación
- [ ] Guardar captura en `capturas/despues/3_exportacion_despues.png`

### FASE 5: NOTIFICACIONES EN TIEMPO REAL
**Paso 1:** Capturar pantalla ANTES (sin notificaciones)
- [ ] Ejecutar aplicación actual
- [ ] Guardar un contacto
- [ ] Exportar contactos
- [ ] Guardar captura en `capturas/antes/4_notificaciones_antes.png`

**Paso 2:** Implementar sistema de notificaciones
- [ ] Crear clase `NotificadorUI` (extends Thread)
- [ ] Implementar notificaciones para:
  - ✓ "Contacto guardado con éxito"
  - ✓ "Validando contacto..."
  - ✓ "Buscando contactos..."
  - ✓ "Exportación completada"
- [ ] Usar SwingUtilities.invokeLater() para actualizar UI
- [ ] Integrar en operaciones principales

**Paso 3:** Capturar pantalla DESPUÉS
- [ ] Ejecutar aplicación con notificaciones
- [ ] Realizar varias operaciones (guardar, buscar, exportar)
- [ ] Capturar notificaciones en tiempo real
- [ ] Guardar captura en `capturas/despues/4_notificaciones_despues.png`

### FASE 6: SINCRONIZACIÓN Y SEGURIDAD
**Paso 1:** Capturar pantalla ANTES (sin sincronización)
- [ ] Ejecutar aplicación actual
- [ ] Intentar editar contacto
- [ ] Guardar captura en `capturas/antes/5_sincronizacion_antes.png`

**Paso 2:** Implementar sincronización
- [ ] Agregar `synchronized` en métodos críticos
- [ ] Crear mecanismo de bloqueo de recursos (locks)
- [ ] Implementar validación de edición exclusiva
- [ ] Mostrar mensaje si contacto está siendo editado

**Paso 3:** Capturar pantalla DESPUÉS
- [ ] Ejecutar aplicación con sincronización
- [ ] Intentar editar contacto
- [ ] Observar bloqueo seguro y mensajes
- [ ] Guardar captura en `capturas/despues/5_sincronizacion_despues.png`

---

## 📊 Comparación de Tiempos

Para el informe, necesitamos medir:

### Búsqueda
- [ ] Tiempo SIN thread (antes)
- [ ] Tiempo CON thread (después)
- [ ] Diferencia en responsividad de UI

### Exportación
- [ ] Tiempo SIN thread (antes)
- [ ] Tiempo CON thread (después)
- [ ] Tiempo de bloqueo de interfaz (antes vs después)

### Validación
- [ ] Tiempo de validación sin thread
- [ ] Tiempo de validación con thread
- [ ] Impacto en experiencia del usuario

---

## 📝 Documentación a Preparar

### Para el Informe PDF:
- [ ] Portada con nombre, fecha, asignatura
- [ ] Índice
- [ ] Explicación de cada mejora aplicada (texto + código relevante)
- [ ] Capturas ANTES de cada feature
- [ ] Capturas DESPUÉS de cada feature
- [ ] Tablas de comparación de tiempos
- [ ] Conclusiones

### Para el Código .zip:
- [ ] Todas las clases de threads comentadas
- [ ] Explicación inline de sincronización
- [ ] Estructura clara de carpetas
- [ ] Archivo README con instrucciones

### Para el Video (máximo 3 minutos):
- [ ] Demostración de cada feature
- [ ] Comparación antes/después
- [ ] Mostrar flujo de threads
- [ ] Explicación breve de cada mejora

---

## 📦 Entrega Final

Nombre del archivo: **Tutillo_Jefferson_ProgInterfacesG_U3**

Contenido:
```
Tutillo_Jefferson_ProgInterfacesG_U3/
├── Tutillo_Jefferson_ProgInterfacesG_U3.pdf (informe)
├── Tutillo_Jefferson_ProgInterfacesG_U3.zip (código fuente)
├── Tutillo_Jefferson_ProgInterfacesG_U3.mp4 (video demostración)
└── capturas/ (todas las imágenes antes y después)
```

---

## ✅ Checklist de Criterios de Evaluación

| Criterio | Estado | Puntos |
|----------|--------|--------|
| Validación de contactos | [ ] | 3 |
| Optimización de búsqueda | [ ] | 2 |
| Exportación concurrente | [ ] | 2 |
| Notificaciones en UI | [ ] | 2 |
| Sincronización y seguridad | [ ] | 2 |
| Documentación y justificación | [ ] | 2 |
| **TOTAL** | | **13 pts** |

---

## 🚀 Próximos Pasos

1. ✅ Revisar este plan
2. ⏳ Empezar con FASE 1: PREPARACIÓN
3. ⏳ Revisar código actual
4. ⏳ Crear estructura de carpetas
5. ⏳ Empezar FASE 2: Validación

**¿Estás listo para comenzar?**
