CREATE TABLE DENTISTA (
    id_dentista NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(11) UNIQUE NOT NULL,
    cro VARCHAR2(15) UNIQUE NOT NULL,
    especialidade VARCHAR2(50),
    endereco VARCHAR2(255)
);


CREATE TABLE PACIENTE (
    id_paciente NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(11) UNIQUE NOT NULL,
    data_nascimento DATE
);


CREATE TABLE SINISTRO (
    id_sinistro NUMBER PRIMARY KEY,
    id_paciente NUMBER REFERENCES PACIENTE(id_paciente),
    data_sinistro DATE NOT NULL,
    descricao VARCHAR2(255),
    valor_reclamado NUMBER NOT NULL
);


CREATE TABLE EMPRESA (
    id_empresa NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cnpj VARCHAR2(14) UNIQUE NOT NULL,
    endereco VARCHAR2(255),
    telefone VARCHAR2(15)
);


CREATE TABLE FUNCIONARIO (
    id_funcionario NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(11) UNIQUE NOT NULL,
    cargo VARCHAR2(50),
    data_admissao DATE
);


CREATE TABLE AUDITORIA_SINISTRO (
    id_auditoria NUMBER PRIMARY KEY,
    id_sinistro NUMBER REFERENCES SINISTRO(id_sinistro),
    id_funcionario NUMBER REFERENCES FUNCIONARIO(id_funcionario),
    data_auditoria DATE NOT NULL,
    resultado VARCHAR2(20) NOT NULL
);
