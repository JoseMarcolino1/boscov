export interface AvaliacaoInput {
  idUsuario: number;
  idFilme: number;
  nota: number;
  comentario: string;
}

export interface AvaliacaoOutput {
  idUsuario: number;
  nomeUsuario: string;
  idFilme: number;
  nomeFilme: string;
  nota: number;
  comentario: string;
}
