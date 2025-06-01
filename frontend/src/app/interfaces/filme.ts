export interface GeneroOutput {
  id: number;
  descricao: string;
}

export interface FilmeOutput {
  id: number;
  nome: string;
  diretor: string;
  anoLancamento: number;
  generos: GeneroOutput[];
  duracao: number;
  produtora: string;
  classificacao: string;
  poster: string;
}
