package edu.eltech.moevm.syntax_tree;

/**
 * Created by vladimir on 31.10.15.
 */
public enum Operation {
    PLUS,   // +
    MINUS,  // -
    MULTIPLY,   // *
    DIVIDE, // /
    UMINUS, //-x
    PERCENT,    //%
    LESS,   //<
    GREATER,  //>
    NOT,    //!
    EQUAL,  //==
    ASSIGNMENT, //=
    NOT_EQ, //!=
    GREATER_OR_EQ,    //>=
    LESS_OR_EQ,  //<=
    LEFT_OP,
    RIGHT_OP,
    AND_OP,
    XOR_OP,
    OR_OP,
    LOGICAL_AND_OP,
    LOGICAL_OR_OP,
    QUESTION_OP,

    EXPRESSION,
    DECLARATION,
    DECLARATION_INIT_LIST,

    DEC_SPEC,

    INIT_LIST,

    INIT_DECLARATION,

    DIRECT_DEC_ARRAY,
    DIRECT_DEC_FUNC,

    PARAM_LIST,

    PARAM_DEC_DIR,
    PARAM_DEC_ABS,
    PARAM_DEC,

    IDENT_LIST,

    DIR_ABS_DEC_BRACKETS,
    DIR_ABS_DEC_BRACKETS_WITH_DEC,

    DIR_ABS_DEC_ROUND,
    DIR_ABS_DEC_ROUND_WITH_DEC,

    ARRAY_INIT,

    INITIALIZER_LIST,

    LABELED,

    COMP_STATEMENT,

    DECL_LIST,
    STAT_LIST,

    TR_UNIT,

    FUNC_DEF,
    EXT_DECL,

    FNDEF_1,
    FNDEF_2,
    FNDEF_3,
    FNDEF_4,


    WHILE,
    DO,
    FOR,
    IF,
    GOTO,
    BREAK,
    RETURN,

    INC_OP,
    DEC_OP,

    FUNC_CALL,

    ARRAY_ACCESS,

    ARGUMENT_EXP_LIST,

    TYPE_CAST,

    SIZEOF,
    SIZEOFTYPE,

    RE,
    IM,
    MOD,

    NEW,

    ROOT
}
