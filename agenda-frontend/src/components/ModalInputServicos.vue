<script setup lang="ts">
import { reactive, ref } from "vue";
import { Servico } from "../domain/Servico";
import {createServico} from "../axios/services/ServicoService"

const ph = ref("");
const dense = ref(true);
const dados = reactive<Servico>({ nome: "", preco: 0 });

const emit = defineEmits(['createServicos',])

async function salveServicos() {
  await createServico(dados)
  emit("createServicos")

}
</script>

<template>
  <div class="filho">
    <div>
      <div>
        <q-input v-model="dados.nome" size="lg" class="input" label="Cliente" placeholder="Insira um cliente válido"
          :dense="dense">
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template></q-input>
      </div>

      <div>
        <q-input v-model="dados.preco" class="input" label="Serviço" placeholder="Insira um Serviço válido"
          :dense="dense">
          <template v-slot:prepend>
            <i class="fa-solid fa-business-time"></i>
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
    </div>
  </div>
</template>
<style scoped>
.filho {
  width: 90%;
}

.filho div {
  margin-bottom: 20px;
}
</style>
