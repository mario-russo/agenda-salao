import { Servico } from "../../domain/Servico"
import configAxios from "../configAxios"

export async function createServico(servico: Servico) {
        await configAxios.post('/servico', servico)

} 

export async function listAllServico(): Promise<Servico[]> {
        const resulado = (await configAxios.get<Servico[]>('/servico')).data
        return resulado
   
}