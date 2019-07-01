// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Person.proto

package com.yzy.proto;

/**
 * Protobuf type {@code com.yzy.protobuf.PersonResponseList}
 */
public  final class PersonResponseList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.yzy.protobuf.PersonResponseList)
    PersonResponseListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PersonResponseList.newBuilder() to construct.
  private PersonResponseList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PersonResponseList() {
    personResponse_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PersonResponseList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              personResponse_ = new java.util.ArrayList<com.yzy.proto.PersonResponse>();
              mutable_bitField0_ |= 0x00000001;
            }
            personResponse_.add(
                input.readMessage(com.yzy.proto.PersonResponse.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        personResponse_ = java.util.Collections.unmodifiableList(personResponse_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.yzy.proto.PersonProto.internal_static_com_yzy_protobuf_PersonResponseList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.yzy.proto.PersonProto.internal_static_com_yzy_protobuf_PersonResponseList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.yzy.proto.PersonResponseList.class, com.yzy.proto.PersonResponseList.Builder.class);
  }

  public static final int PERSONRESPONSE_FIELD_NUMBER = 1;
  private java.util.List<com.yzy.proto.PersonResponse> personResponse_;
  /**
   * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
   */
  public java.util.List<com.yzy.proto.PersonResponse> getPersonResponseList() {
    return personResponse_;
  }
  /**
   * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
   */
  public java.util.List<? extends com.yzy.proto.PersonResponseOrBuilder> 
      getPersonResponseOrBuilderList() {
    return personResponse_;
  }
  /**
   * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
   */
  public int getPersonResponseCount() {
    return personResponse_.size();
  }
  /**
   * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
   */
  public com.yzy.proto.PersonResponse getPersonResponse(int index) {
    return personResponse_.get(index);
  }
  /**
   * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
   */
  public com.yzy.proto.PersonResponseOrBuilder getPersonResponseOrBuilder(
      int index) {
    return personResponse_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < personResponse_.size(); i++) {
      output.writeMessage(1, personResponse_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < personResponse_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, personResponse_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.yzy.proto.PersonResponseList)) {
      return super.equals(obj);
    }
    com.yzy.proto.PersonResponseList other = (com.yzy.proto.PersonResponseList) obj;

    if (!getPersonResponseList()
        .equals(other.getPersonResponseList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getPersonResponseCount() > 0) {
      hash = (37 * hash) + PERSONRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getPersonResponseList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.yzy.proto.PersonResponseList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yzy.proto.PersonResponseList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.yzy.proto.PersonResponseList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yzy.proto.PersonResponseList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.yzy.proto.PersonResponseList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.yzy.protobuf.PersonResponseList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.yzy.protobuf.PersonResponseList)
      com.yzy.proto.PersonResponseListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yzy.proto.PersonProto.internal_static_com_yzy_protobuf_PersonResponseList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yzy.proto.PersonProto.internal_static_com_yzy_protobuf_PersonResponseList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yzy.proto.PersonResponseList.class, com.yzy.proto.PersonResponseList.Builder.class);
    }

    // Construct using com.yzy.proto.PersonResponseList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPersonResponseFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (personResponseBuilder_ == null) {
        personResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        personResponseBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.yzy.proto.PersonProto.internal_static_com_yzy_protobuf_PersonResponseList_descriptor;
    }

    @java.lang.Override
    public com.yzy.proto.PersonResponseList getDefaultInstanceForType() {
      return com.yzy.proto.PersonResponseList.getDefaultInstance();
    }

    @java.lang.Override
    public com.yzy.proto.PersonResponseList build() {
      com.yzy.proto.PersonResponseList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.yzy.proto.PersonResponseList buildPartial() {
      com.yzy.proto.PersonResponseList result = new com.yzy.proto.PersonResponseList(this);
      int from_bitField0_ = bitField0_;
      if (personResponseBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          personResponse_ = java.util.Collections.unmodifiableList(personResponse_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.personResponse_ = personResponse_;
      } else {
        result.personResponse_ = personResponseBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.yzy.proto.PersonResponseList) {
        return mergeFrom((com.yzy.proto.PersonResponseList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.yzy.proto.PersonResponseList other) {
      if (other == com.yzy.proto.PersonResponseList.getDefaultInstance()) return this;
      if (personResponseBuilder_ == null) {
        if (!other.personResponse_.isEmpty()) {
          if (personResponse_.isEmpty()) {
            personResponse_ = other.personResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePersonResponseIsMutable();
            personResponse_.addAll(other.personResponse_);
          }
          onChanged();
        }
      } else {
        if (!other.personResponse_.isEmpty()) {
          if (personResponseBuilder_.isEmpty()) {
            personResponseBuilder_.dispose();
            personResponseBuilder_ = null;
            personResponse_ = other.personResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
            personResponseBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPersonResponseFieldBuilder() : null;
          } else {
            personResponseBuilder_.addAllMessages(other.personResponse_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.yzy.proto.PersonResponseList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.yzy.proto.PersonResponseList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.yzy.proto.PersonResponse> personResponse_ =
      java.util.Collections.emptyList();
    private void ensurePersonResponseIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        personResponse_ = new java.util.ArrayList<com.yzy.proto.PersonResponse>(personResponse_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.yzy.proto.PersonResponse, com.yzy.proto.PersonResponse.Builder, com.yzy.proto.PersonResponseOrBuilder> personResponseBuilder_;

    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public java.util.List<com.yzy.proto.PersonResponse> getPersonResponseList() {
      if (personResponseBuilder_ == null) {
        return java.util.Collections.unmodifiableList(personResponse_);
      } else {
        return personResponseBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public int getPersonResponseCount() {
      if (personResponseBuilder_ == null) {
        return personResponse_.size();
      } else {
        return personResponseBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public com.yzy.proto.PersonResponse getPersonResponse(int index) {
      if (personResponseBuilder_ == null) {
        return personResponse_.get(index);
      } else {
        return personResponseBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder setPersonResponse(
        int index, com.yzy.proto.PersonResponse value) {
      if (personResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePersonResponseIsMutable();
        personResponse_.set(index, value);
        onChanged();
      } else {
        personResponseBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder setPersonResponse(
        int index, com.yzy.proto.PersonResponse.Builder builderForValue) {
      if (personResponseBuilder_ == null) {
        ensurePersonResponseIsMutable();
        personResponse_.set(index, builderForValue.build());
        onChanged();
      } else {
        personResponseBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder addPersonResponse(com.yzy.proto.PersonResponse value) {
      if (personResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePersonResponseIsMutable();
        personResponse_.add(value);
        onChanged();
      } else {
        personResponseBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder addPersonResponse(
        int index, com.yzy.proto.PersonResponse value) {
      if (personResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePersonResponseIsMutable();
        personResponse_.add(index, value);
        onChanged();
      } else {
        personResponseBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder addPersonResponse(
        com.yzy.proto.PersonResponse.Builder builderForValue) {
      if (personResponseBuilder_ == null) {
        ensurePersonResponseIsMutable();
        personResponse_.add(builderForValue.build());
        onChanged();
      } else {
        personResponseBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder addPersonResponse(
        int index, com.yzy.proto.PersonResponse.Builder builderForValue) {
      if (personResponseBuilder_ == null) {
        ensurePersonResponseIsMutable();
        personResponse_.add(index, builderForValue.build());
        onChanged();
      } else {
        personResponseBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder addAllPersonResponse(
        java.lang.Iterable<? extends com.yzy.proto.PersonResponse> values) {
      if (personResponseBuilder_ == null) {
        ensurePersonResponseIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, personResponse_);
        onChanged();
      } else {
        personResponseBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder clearPersonResponse() {
      if (personResponseBuilder_ == null) {
        personResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        personResponseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public Builder removePersonResponse(int index) {
      if (personResponseBuilder_ == null) {
        ensurePersonResponseIsMutable();
        personResponse_.remove(index);
        onChanged();
      } else {
        personResponseBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public com.yzy.proto.PersonResponse.Builder getPersonResponseBuilder(
        int index) {
      return getPersonResponseFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public com.yzy.proto.PersonResponseOrBuilder getPersonResponseOrBuilder(
        int index) {
      if (personResponseBuilder_ == null) {
        return personResponse_.get(index);  } else {
        return personResponseBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public java.util.List<? extends com.yzy.proto.PersonResponseOrBuilder> 
         getPersonResponseOrBuilderList() {
      if (personResponseBuilder_ != null) {
        return personResponseBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(personResponse_);
      }
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public com.yzy.proto.PersonResponse.Builder addPersonResponseBuilder() {
      return getPersonResponseFieldBuilder().addBuilder(
          com.yzy.proto.PersonResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public com.yzy.proto.PersonResponse.Builder addPersonResponseBuilder(
        int index) {
      return getPersonResponseFieldBuilder().addBuilder(
          index, com.yzy.proto.PersonResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.yzy.protobuf.PersonResponse personResponse = 1;</code>
     */
    public java.util.List<com.yzy.proto.PersonResponse.Builder> 
         getPersonResponseBuilderList() {
      return getPersonResponseFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.yzy.proto.PersonResponse, com.yzy.proto.PersonResponse.Builder, com.yzy.proto.PersonResponseOrBuilder> 
        getPersonResponseFieldBuilder() {
      if (personResponseBuilder_ == null) {
        personResponseBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.yzy.proto.PersonResponse, com.yzy.proto.PersonResponse.Builder, com.yzy.proto.PersonResponseOrBuilder>(
                personResponse_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        personResponse_ = null;
      }
      return personResponseBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.yzy.protobuf.PersonResponseList)
  }

  // @@protoc_insertion_point(class_scope:com.yzy.protobuf.PersonResponseList)
  private static final com.yzy.proto.PersonResponseList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.yzy.proto.PersonResponseList();
  }

  public static com.yzy.proto.PersonResponseList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PersonResponseList>
      PARSER = new com.google.protobuf.AbstractParser<PersonResponseList>() {
    @java.lang.Override
    public PersonResponseList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PersonResponseList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PersonResponseList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PersonResponseList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.yzy.proto.PersonResponseList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
