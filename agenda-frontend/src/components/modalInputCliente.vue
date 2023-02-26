<script setup lang="ts">
import { reactive, ref } from "vue";
import configAxios from "../axios/configAxios";
import { createCliente } from "../axios/services/ClienteService";
import { Cliente } from "../domain/Cliente";

const ph = ref("");
const dense = ref(true);
const dados = reactive<Cliente>({ nome: "", email: "", telefone: "" });

const emit = defineEmits(["createCliente"]);

function salveServicos() {
  createCliente(dados);
  emit("createCliente");
}
</script>

<template>
  <div class="filho">
    <div>
      <div>
        <q-input
          v-model="dados.nome"
          outlined
          size="lg"
          class="input"
          label="NOME"
          placeholder="Insira o Nome do Cliente"
          :dense="dense"
        >
          <template v-slot:prepend> <i class="fa-regular fa-user"></i></template
        ></q-input>
      </div>

      <div>
        <q-input
          v-model="dados.email"
          outlined
          class="input"
          label="E-mail"
          :dense="dense"
        >
          <template v-slot:prepend>
            <i class="fa-solid fa-envelope"></i>
          </template>
        </q-input>
      </div>
      <div>
        <q-input
          v-model="dados.telefone"
          outlined
          class="input"
          label="Telefone"
          placeholder="Insira um o nome do Telefone"
          :dense="dense"
        >
          <template v-slot:prepend>
            <i class="fa-solid fa-phone"></i>
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
.filho div {
  margin-bottom: 20px;
}
</style>
