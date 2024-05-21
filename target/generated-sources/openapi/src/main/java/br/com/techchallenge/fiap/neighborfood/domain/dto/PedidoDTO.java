package br.com.techchallenge.fiap.neighborfood.domain.dto;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PedidoDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T23:19:13.374846-03:00[America/Sao_Paulo]")
public class PedidoDTO {

  private Long id;

  private Long idCliente;

  @Valid
  private List<@Valid ProdutoDTO> itens;

  public PedidoDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PedidoDTO idCliente(Long idCliente) {
    this.idCliente = idCliente;
    return this;
  }

  /**
   * Get idCliente
   * @return idCliente
  */
  
  @Schema(name = "idCliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idCliente")
  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public PedidoDTO itens(List<@Valid ProdutoDTO> itens) {
    this.itens = itens;
    return this;
  }

  public PedidoDTO addItensItem(ProdutoDTO itensItem) {
    if (this.itens == null) {
      this.itens = new ArrayList<>();
    }
    this.itens.add(itensItem);
    return this;
  }

  /**
   * Get itens
   * @return itens
  */
  @Valid 
  @Schema(name = "Itens", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Itens")
  public List<@Valid ProdutoDTO> getItens() {
    return itens;
  }

  public void setItens(List<@Valid ProdutoDTO> itens) {
    this.itens = itens;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PedidoDTO pedidoDTO = (PedidoDTO) o;
    return Objects.equals(this.id, pedidoDTO.id) &&
        Objects.equals(this.idCliente, pedidoDTO.idCliente) &&
        Objects.equals(this.itens, pedidoDTO.itens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idCliente, itens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PedidoDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
