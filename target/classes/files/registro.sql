-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-12-2017 a las 16:48:47
-- Versión del servidor: 5.7.20-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registro_horas_na_at`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_actividades`
--

CREATE TABLE `bitacora_actividades` (
  `id_proyecto` int(5) NOT NULL,
  `id_plan_trabajo_detallado` int(5) NOT NULL,
  `id_subtarea_bitacora_actividades` int(5) NOT NULL,
  `id_usuario` int(5) NOT NULL,
  `id_tarea_plan_de_trabajo` int(5) NOT NULL,
  `fecha_planeada` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_clientes` int(11) NOT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_clientes`, `nombre_cliente`) VALUES
(1, 'NA-AT Technologies'),
(2, 'MetLife'),
(3, 'Inbursa'),
(4, 'Axa'),
(5, 'Credit Suisse'),
(6, 'Intercam'),
(7, 'Scotiabank'),
(8, 'Verifone'),
(9, 'Santander'),
(10, 'Banregio'),
(11, 'HSBC'),
(12, 'RSA'),
(13, 'Banorte'),
(14, 'Banco Azteca'),
(15, 'Ci Banco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entregables`
--

CREATE TABLE `entregables` (
  `id_entregable` int(5) NOT NULL,
  `wbs_entregable` int(5) NOT NULL,
  `etapa` varchar(16) NOT NULL,
  `tipo` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entregables`
--

INSERT INTO `entregables` (`id_entregable`, `wbs_entregable`, `etapa`, `tipo`) VALUES
(1, 1, 'Análisis', 'SRS'),
(1, 2, 'Análisis', 'Wireframe'),
(1, 3, 'Análisis', 'Mockups'),
(1, 4, 'Análisis', 'Casos de pruebas de sistema'),
(1, 5, 'Análisis', 'Tarea genérica de la fase de Análisis'),
(2, 1, 'Diseño', 'Documento de Arquitectura'),
(2, 2, 'Diseño', 'Diseño Detallado'),
(2, 3, 'Diseño ', 'Casos de pruebas de integración'),
(2, 4, 'Diseño', 'Tarea generérica de Diseño'),
(3, 1, 'Codificación', 'Código fuente'),
(3, 2, 'Codificación', 'Casos de pruebas de unidad'),
(3, 3, 'Codificación', 'Tarea generérica de Codificación'),
(4, 1, 'Pruebas', 'Ejecutar pruebas de unidad'),
(4, 2, 'Pruebas', 'Ejecutar pruebas de integración'),
(4, 3, 'Prueba', 'Ejecutar pruebas de sistema'),
(4, 4, 'Pruebas', 'Corregir errores de pruebas de unidad'),
(4, 5, 'Pruebas', 'Corregir errores de pruebas de intregración'),
(4, 6, 'Pruebas', 'Corregir errores de pruebas de sistema'),
(4, 7, 'Pruebas', 'Tarea genérica de Pruebas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fases_proceso`
--

CREATE TABLE `fases_proceso` (
  `id_fase_proceso` int(5) NOT NULL,
  `wbs_fase` int(5) NOT NULL,
  `tipo` varchar(16) NOT NULL,
  `fase` varchar(80) NOT NULL,
  `porcentaje_distribucion` decimal(4,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `fases_proceso`
--

INSERT INTO `fases_proceso` (`id_fase_proceso`, `wbs_fase`, `tipo`, `fase`, `porcentaje_distribucion`) VALUES
(1, 2, 'Documento', 'Creación', '0.500'),
(2, 4, 'Documento', 'Revisión', '0.150'),
(3, 6, 'Documento', 'Corrección de la revisión', '0.100'),
(4, 8, 'Documento', 'Inspección', '0.150'),
(5, 10, 'Documento', 'Corrección de la inspección', '0.100'),
(6, 2, 'Componente', 'Codificación', '0.500'),
(7, 6, 'Componente', 'Revisión de código', '0.150'),
(8, 9, 'Componente', 'Corrección de revision', '0.100'),
(9, 10, 'Componente', 'Inspección', '0.150'),
(10, 11, 'Componente', 'Corrección de la Inspección', '0.100');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listas_plan_de_trabajo`
--

CREATE TABLE `listas_plan_de_trabajo` (
  `id_lista_plan_de_trabajo` int(5) NOT NULL,
  `id_proyecto` int(5) NOT NULL,
  `descripcion_plan_de_trabajo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_usuario`
--

CREATE TABLE `perfil_usuario` (
  `id_perfil_usuario` int(5) NOT NULL,
  `descripcion` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil_usuario`
--

INSERT INTO `perfil_usuario` (`id_perfil_usuario`, `descripcion`) VALUES
(1, 'PM'),
(2, 'Web');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_de_trabajo`
--

CREATE TABLE `plan_de_trabajo` (
  `id_lista_plan_de_trabajo` int(5) NOT NULL,
  `id_tarea_plan_de_trabajo` int(5) NOT NULL,
  `nombre_tarea_capturada` varchar(250) NOT NULL,
  `fecha_planeada` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_de_trabajo_detallado`
--

CREATE TABLE `plan_de_trabajo_detallado` (
  `id_proyecto` int(5) NOT NULL,
  `id_tarea_plan_de_trabajo` int(5) NOT NULL,
  `id_plan_trabajo_detallado` int(5) NOT NULL,
  `id_entregable` int(5) NOT NULL,
  `wbs_entregable` int(5) NOT NULL,
  `nombre_subtarea` varchar(255) NOT NULL,
  `fecha_planeada` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `id_proyecto` int(5) NOT NULL,
  `clave_proyecto` int(5) NOT NULL,
  `nombre_corto` varchar(50) NOT NULL,
  `nombre_largo` varchar(100) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `id_clientes` int(5) NOT NULL,
  `id_usuario` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`id_proyecto`, `clave_proyecto`, `nombre_corto`, `nombre_largo`, `descripcion`, `id_clientes`, `id_usuario`) VALUES
(1, 1, 'FAD', 'Firma Autografa Digital', 'Robusta plataforma tecnológica para captura y validación biométrica que combate la suplantación de la identidad, al tiempo de cumplir con las disposiciones de la CUB 2017.', 1, 2),
(2, 2, 'MetLife CUO RP', 'MetLife CUO Retiros Parciales', 'Proyecto Metlife', 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(5) NOT NULL,
  `id_perfil_usuario` int(5) NOT NULL,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `ap_paterno` varchar(50) DEFAULT NULL,
  `ap_materno` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `ap_materno_usuario` varchar(255) DEFAULT NULL,
  `ap_paterno_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `id_perfil_usuario`, `nombre_usuario`, `ap_paterno`, `ap_materno`, `email`, `contrasenia`, `ap_materno_usuario`, `ap_paterno_usuario`) VALUES
(1, 2, 'Angel Salvador', 'Herrera', 'Hernandez', 'aherrera@na-at.com.mx', '12345', 'Hernandez', 'Herrera'),
(2, 1, 'Alfredo', 'Villanueva', 'Pastor', 'avillanueva@na-at.com.mx', '12345', 'Villanueva', 'Pastor'),
(3, 2, 'Zaira', 'Calderon', 'Flores', 'zcalderon@na-at.com.mx', '123', 'Flores', 'Calderon'),
(4, 1, 'Jorge Enrique', 'Reyes', 'Nicolin', 'jreyes@na-at.com.mx', 'reyes', 'Nicolin', 'Reyes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_proyecto`
--

CREATE TABLE `usuario_proyecto` (
  `id_proyecto` int(5) NOT NULL,
  `id_usuario` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario_proyecto`
--

INSERT INTO `usuario_proyecto` (`id_proyecto`, `id_usuario`) VALUES
(1, 1),
(2, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_clientes`);

--
-- Indices de la tabla `entregables`
--
ALTER TABLE `entregables`
  ADD PRIMARY KEY (`id_entregable`,`wbs_entregable`);

--
-- Indices de la tabla `fases_proceso`
--
ALTER TABLE `fases_proceso`
  ADD PRIMARY KEY (`id_fase_proceso`,`wbs_fase`);

--
-- Indices de la tabla `listas_plan_de_trabajo`
--
ALTER TABLE `listas_plan_de_trabajo`
  ADD PRIMARY KEY (`id_lista_plan_de_trabajo`),
  ADD KEY `fk_listas_plan_de_trabajo_proyecto_1` (`id_proyecto`);

--
-- Indices de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  ADD PRIMARY KEY (`id_perfil_usuario`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id_proyecto`),
  ADD KEY `fk_proyecto_usuario_1` (`id_usuario`),
  ADD KEY `FKcl6x7nqret6po1736qrpeeiqn` (`id_clientes`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_perfil_usuario_1` (`id_perfil_usuario`);

--
-- Indices de la tabla `usuario_proyecto`
--
ALTER TABLE `usuario_proyecto`
  ADD PRIMARY KEY (`id_proyecto`,`id_usuario`),
  ADD KEY `fk_usuario_proyecto_usuario_1` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacora_actividades`
--
ALTER TABLE `bitacora_actividades`
  MODIFY `id_subtarea_bitacora_actividades` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_clientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `fases_proceso`
--
ALTER TABLE `fases_proceso`
  MODIFY `id_fase_proceso` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `listas_plan_de_trabajo`
--
ALTER TABLE `listas_plan_de_trabajo`
  MODIFY `id_lista_plan_de_trabajo` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  MODIFY `id_perfil_usuario` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `plan_de_trabajo`
--
ALTER TABLE `plan_de_trabajo`
  MODIFY `id_tarea_plan_de_trabajo` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `plan_de_trabajo_detallado`
--
ALTER TABLE `plan_de_trabajo_detallado`
  MODIFY `id_plan_trabajo_detallado` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id_proyecto` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `listas_plan_de_trabajo`
--
ALTER TABLE `listas_plan_de_trabajo`
  ADD CONSTRAINT `fk_listas_plan_de_trabajo_proyecto_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`);

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `FKcl6x7nqret6po1736qrpeeiqn` FOREIGN KEY (`id_clientes`) REFERENCES `cliente` (`id_clientes`),
  ADD CONSTRAINT `fk_proyecto_cliente_1` FOREIGN KEY (`id_clientes`) REFERENCES `cliente` (`id_clientes`),
  ADD CONSTRAINT `fk_proyecto_usuario_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_perfil_usuario_1` FOREIGN KEY (`id_perfil_usuario`) REFERENCES `perfil_usuario` (`id_perfil_usuario`);

--
-- Filtros para la tabla `usuario_proyecto`
--
ALTER TABLE `usuario_proyecto`
  ADD CONSTRAINT `fk_usuario_proyecto_proyecto_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`),
  ADD CONSTRAINT `fk_usuario_proyecto_usuario_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
