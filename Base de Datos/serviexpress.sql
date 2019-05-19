-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2019 a las 23:36:41
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `serviexpress`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_personas` int(11) NOT NULL,
  `natural_empresa` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_personas` int(11) NOT NULL,
  `nivel_acceso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familias`
--

CREATE TABLE `familias` (
  `id_familias` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `boleta_factura` tinyint(1) NOT NULL,
  `total_neto` int(11) NOT NULL,
  `descuento` int(11) NOT NULL,
  `total_final` int(11) NOT NULL,
  `anulada` char(1) COLLATE utf8_bin NOT NULL,
  `reservas_id_reservas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedidos` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `empleados_id_personas` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id_personas` int(11) NOT NULL,
  `rut` int(11) NOT NULL,
  `digito_verificador` char(1) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `paterno` varchar(30) COLLATE utf8_bin NOT NULL,
  `materno` varchar(30) COLLATE utf8_bin NOT NULL,
  `direccion` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefono` int(11) NOT NULL,
  `telefono2` int(11) DEFAULT NULL,
  `usuario` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(30) COLLATE utf8_bin NOT NULL,
  `e_mail` varchar(30) COLLATE utf8_bin NOT NULL,
  `activa` char(1) COLLATE utf8_bin NOT NULL,
  `tipo_personas` enum('c','e') COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(17) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `fecha_vencimiento` datetime NOT NULL,
  `proveedores_id_proveedor` int(3) NOT NULL,
  `tipos_id_tipos` int(3) NOT NULL,
  `familias_id_familias` int(3) NOT NULL,
  `precio_compra` int(11) NOT NULL,
  `precio_venta` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `stock_critico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_pedidos`
--

CREATE TABLE `productos_pedidos` (
  `productos_id_productos` int(11) NOT NULL,
  `pedidos_id_pedidos` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_reservas`
--

CREATE TABLE `productos_reservas` (
  `cantidad` int(11) NOT NULL,
  `reservas_id_reservas` int(11) NOT NULL,
  `productos_id_productos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `rubro` varchar(30) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `direccion` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefono` int(11) NOT NULL,
  `e_mail` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE `recepciones` (
  `id_recepcion` int(11) NOT NULL,
  `pedidos_id_pedidos` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_emp_recep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reservas` int(11) NOT NULL,
  `empleados_id_personas` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `observaciones` varchar(200) COLLATE utf8_bin NOT NULL,
  `se_atendio` char(1) COLLATE utf8_bin NOT NULL,
  `clientes_id_personas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas_servicios`
--

CREATE TABLE `reservas_servicios` (
  `reservas_id_reservas` int(11) NOT NULL,
  `servicios_id_servicios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicios` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `precio` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos`
--

CREATE TABLE `tipos` (
  `id_tipos` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id_personas` int(11) NOT NULL,
  `patente` varchar(30) COLLATE utf8_bin NOT NULL,
  `tipo` char(1) COLLATE utf8_bin NOT NULL,
  `modelo` varchar(30) COLLATE utf8_bin NOT NULL,
  `color` varchar(15) COLLATE utf8_bin NOT NULL,
  `anio` datetime(6) NOT NULL,
  `motor` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_personas`),
  ADD UNIQUE KEY `clientes__idx` (`id_personas`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_personas`),
  ADD UNIQUE KEY `empleados_idx` (`id_personas`);

--
-- Indices de la tabla `familias`
--
ALTER TABLE `familias`
  ADD PRIMARY KEY (`id_familias`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `pagos_reservas_fk` (`reservas_id_reservas`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedidos`),
  ADD KEY `pedidos_empleados_fk` (`empleados_id_personas`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id_personas`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `productos_familias_fk` (`familias_id_familias`),
  ADD KEY `productos_proveedores_fk` (`proveedores_id_proveedor`),
  ADD KEY `productos_tipos_fk` (`tipos_id_tipos`);

--
-- Indices de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD PRIMARY KEY (`pedidos_id_pedidos`,`productos_id_productos`),
  ADD KEY `PRODUCTOS-PEDIDOS_PRODUCTOS_FK` (`productos_id_productos`),
  ADD KEY `PRODUCTOS_PEDIDOS_PEDIDOS_FK` (`pedidos_id_pedidos`);

--
-- Indices de la tabla `productos_reservas`
--
ALTER TABLE `productos_reservas`
  ADD PRIMARY KEY (`reservas_id_reservas`,`productos_id_productos`),
  ADD KEY `prod_res_prod_fk` (`productos_id_productos`),
  ADD KEY `productos_reservas_reservas_fk` (`reservas_id_reservas`) USING BTREE;

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD PRIMARY KEY (`id_recepcion`),
  ADD UNIQUE KEY `recepcion__idx` (`pedidos_id_pedidos`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reservas`),
  ADD KEY `reservas_clientes_fk` (`clientes_id_personas`);

--
-- Indices de la tabla `reservas_servicios`
--
ALTER TABLE `reservas_servicios`
  ADD PRIMARY KEY (`reservas_id_reservas`,`servicios_id_servicios`),
  ADD KEY `res_serv_serv_fk` (`servicios_id_servicios`) USING BTREE,
  ADD KEY `res_serv_res_fk` (`reservas_id_reservas`) USING BTREE;

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicios`);

--
-- Indices de la tabla `tipos`
--
ALTER TABLE `tipos`
  ADD PRIMARY KEY (`id_tipos`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`patente`),
  ADD KEY `id_personas` (`id_personas`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_personas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_personas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `familias`
--
ALTER TABLE `familias`
  MODIFY `id_familias` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedidos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id_personas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(17) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_personas_fk` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleado_personas_fk` FOREIGN KEY (`id_personas`) REFERENCES `personas` (`id_personas`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_reservas_fk` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_empleados_fk` FOREIGN KEY (`empleados_id_personas`) REFERENCES `empleados` (`id_personas`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_familias_fk` FOREIGN KEY (`familias_id_familias`) REFERENCES `familias` (`id_familias`),
  ADD CONSTRAINT `productos_proveedores_fk` FOREIGN KEY (`proveedores_id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  ADD CONSTRAINT `productos_tipos_fk` FOREIGN KEY (`tipos_id_tipos`) REFERENCES `tipos` (`id_tipos`);

--
-- Filtros para la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD CONSTRAINT `PRODUCTOS-PEDIDOS_PEDIDOS_FK` FOREIGN KEY (`pedidos_id_pedidos`) REFERENCES `pedidos` (`id_pedidos`),
  ADD CONSTRAINT `PRODUCTOS-PEDIDOS_PRODUCTOS_FK` FOREIGN KEY (`productos_id_productos`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `productos_reservas`
--
ALTER TABLE `productos_reservas`
  ADD CONSTRAINT `pro_res_res_fk` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`),
  ADD CONSTRAINT `prod_res_prod_fk` FOREIGN KEY (`productos_id_productos`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD CONSTRAINT `recepciones_pedidos_fk` FOREIGN KEY (`pedidos_id_pedidos`) REFERENCES `pedidos` (`id_pedidos`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_clientes_fk` FOREIGN KEY (`clientes_id_personas`) REFERENCES `clientes` (`id_personas`);

--
-- Filtros para la tabla `reservas_servicios`
--
ALTER TABLE `reservas_servicios`
  ADD CONSTRAINT `reservas_servicios_ibfk_1` FOREIGN KEY (`servicios_id_servicios`) REFERENCES `servicios` (`id_servicios`),
  ADD CONSTRAINT `reservas_servicios_ibfk_2` FOREIGN KEY (`reservas_id_reservas`) REFERENCES `reservas` (`id_reservas`);

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_personas`) REFERENCES `clientes` (`id_personas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;






