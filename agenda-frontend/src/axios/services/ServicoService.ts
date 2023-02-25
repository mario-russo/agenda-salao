import { Servico } from "../../domain/Servico"
import configAxios from "../configAxios"

export async function createServico(servico: Servico) {
    try {
        await configAxios.post('/servico', servico)

    } catch (error) {
        return error
    }
}

export async function listAllServico(): Promise<Servico[]> {
    try {
        const resulado = (await configAxios.get<Servico[]>('/servico')).data
        return resulado
    } catch (error:any) {
        return error
    }

}