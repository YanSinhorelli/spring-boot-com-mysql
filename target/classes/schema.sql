CREATE TABLE IF NOT EXISTS `trilha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trilha_nome` varchar(35) DEFAULT NULL,
  `diretoria` varchar(30) DEFAULT NULL,
  `missao_formal` varchar(270) DEFAULT NULL,
  `missao_alternativa` varchar(126) DEFAULT NULL,
  `data_atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_nome` varchar(53) DEFAULT NULL,
  `trilha_id` int(11) NOT NULL,
  `cargo_missao` varchar(492) DEFAULT NULL,
  `data_atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (trilha_id) REFERENCES trilha (id)
);
