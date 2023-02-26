<script setup lang="ts">
import { reactive, ref } from "vue";
import { Servico } from "../domain/Servico";
import { createServico } from "../axios/services/ServicoService";

const ph = ref("");
const dense = ref(true);
const dados = reactive<Servico>({ nome: "", preco: 0 });

const emit = defineEmits(["createServicos"]);

async function salveServicos() {
  await createServico(dados);
  emit("createServicos");
}
</script>

<template>
 
      <div>
        <q-input
          v-model="dados.nome"
          outlined
          size="lg"
          class="input"
          label="Tipo de serviço"
          placeholder="Nome do serviço"
          :dense="dense"
        >
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template
        ></q-input>
      </div>

      <div>
        <q-input
          v-model="dados.preco"
          outlined
          class="input"
          label="Valor"
          placeholder="Valor do serviço"
          :dense="dense"
        >
          <template v-slot:prepend>
            <i class="fa-solid fa-money-bill"></i>
          </template>
        </q-input>
      </div>
      <q-space></q-space>
      <div>
        <q-btn-group spread>
          <q-btn color="purple" label="" icon="cancel" />
          <q-btn color="purple" label="" icon="send" @click="salveServicos()" />
        </q-btn-group>
      </div>

</template>
<style scoped>


 div {
  margin-bottom: 20px;
}
</style>
