<script setup lang="ts">
import { reactive, ref } from "vue";
import configAxios from "../axios/configAxios";
import { Cliente } from "../domain/Cliente";

const ph = ref("");
const dense = ref(true);
const dados = reactive<Cliente>({ nome: "", email: '', telefone: '' });

const emit = defineEmits(["createCliente"])

function createServicos() {
  configAxios.post("/cliente", dados);
  emit("createCliente")
}
</script>

<template>
  <div class="filho">
    <div>
      <div>
        <q-input v-model="dados.nome" size="lg" class="input" label="NOME" placeholder="Insira o Nome do Cliente"
          :dense="dense">
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template></q-input>
      </div>

      <div>
        <q-input v-model="dados.email" class="input" label="E-mail" placeholder="Insira um o nome do Cliente"
          :dense="dense">
          <template v-slot:prepend>
            <i class="fa-solid fa-business-time"></i>
          </template>
        </q-input>
      </div>
      <div>
        <q-input v-model="dados.telefone" class="input" label="Telefone" placeholder="Insira um o nome do Telefone"
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
          <q-btn color="purple" label="" icon="send" @click="createServicos()" />
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
